package org.hisp.dhis.rules.models;

import com.google.auto.value.AutoValue;
import com.google.common.collect.Maps;
import org.hisp.dhis.rules.RuleVariableValue;
import org.hisp.dhis.rules.RuleVariableValueMapBuilder;
import org.hisp.dhis.rules.Utils;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

import static org.hisp.dhis.rules.Utils.getLastUpdateDateForPrevious;

@AutoValue
public abstract class RuleVariablePreviousEvent
    extends RuleVariableDataElement
{

    @Nonnull
    public static RuleVariablePreviousEvent create( @Nonnull String name,
        @Nonnull String dataElement, @Nonnull RuleValueType valueType )
    {
        return new AutoValue_RuleVariablePreviousEvent( name, dataElement, valueType );
    }

    @Override
    public Map<String, RuleVariableValue> createValues( RuleVariableValueMapBuilder builder,
        Map<String, List<RuleDataValue>> allEventValues,
        Map<String, RuleAttributeValue> currentEnrollmentValues,
        Map<String, RuleDataValue> currentEventValues )
    {
        Map<String, RuleVariableValue> valueMap = Maps.newHashMap();
        if ( builder.ruleEvent == null )
        {
            return valueMap;
        }

        RuleVariableValue variableValue = null;
        List<RuleDataValue> ruleDataValues = allEventValues.get( this.dataElement() );
        if ( ruleDataValues != null && !ruleDataValues.isEmpty() )
        {
            for ( RuleDataValue ruleDataValue : ruleDataValues )
            {
                // We found preceding value to the current currentEventValues,
                // which is assumed to be best candidate.
                if ( builder.ruleEvent.eventDate().compareTo( ruleDataValue.eventDate() ) > 0 )
                {
                    variableValue = RuleVariableValue.create( ruleDataValue.value(), this.dataElementType(),
                        Utils.values( ruleDataValues ),
                        getLastUpdateDateForPrevious( ruleDataValues, builder.ruleEvent ) );
                    break;
                }
            }
        }

        if ( variableValue == null )
        {
            variableValue = RuleVariableValue.create( this.dataElementType() );
        }

        valueMap.put( this.name(), variableValue );
        return valueMap;
    }
}
