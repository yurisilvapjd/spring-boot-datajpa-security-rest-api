package com.yurisilvapjd.springbootdatajpasecurityrestapi.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails {

    protected String title;
    protected int status;
    protected String details;
    protected Long timestamp;
    protected String developerMessage;


    public static final class Builder {
        protected String title;
        protected int status;
        protected String details;
        protected Long timestamp;
        protected String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder details(String details) {
            this.details = details;
            return this;
        }

        public Builder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ErrorDetails build() {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setTitle(title);
            errorDetails.setStatus(status);
            errorDetails.setDetails(details);
            errorDetails.setTimestamp(timestamp);
            errorDetails.setDeveloperMessage(developerMessage);
            return errorDetails;
        }
    }
}
