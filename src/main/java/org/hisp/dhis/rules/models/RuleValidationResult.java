package org.hisp.dhis.rules.models;

/*
 * Copyright (c) 2004-2020, University of Oslo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * @author Zubair Asghar
 */
public class RuleValidationResult
{
    private String description;
    private boolean isValid;
    private String errorMessage;

    public RuleValidationResult( String description, boolean isValid, String errorMessage )
    {
        this.description = description;
        this.isValid = isValid;
        this.errorMessage = errorMessage;
    }

    public String getDescription()
    {
        return description;
    }

    public boolean isValid()
    {
        return isValid;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public static class Builder
    {
        private String description;
        private boolean isValid;
        private String errorMessage;

        public Builder description( String description )
        {
            this.description = description;
            return this;
        }

        public Builder isValid( boolean isValid )
        {
            this.isValid = isValid;
            return this;
        }

        public Builder errorMessage( String errorMessage )
        {
            this.errorMessage = errorMessage;
            return this;
        }

        public RuleValidationResult build()
        {
            return new RuleValidationResult( this.description, this.isValid, this.errorMessage );
        }
    }
}
