package at.mps.builder;

import java.util.List;

public class Name {

    private final String firstName;
    private final List<String> middleName;
    private final String surName;


    private Name(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.surName = builder.surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<String> getMiddleName() {
        return middleName;
    }

    public String getSurName() {
        return surName;
    }


    public static class Builder {

        private String firstName;
        private List<String> middleName;
        private String surName;


        public Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(final List<String> middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder surName(final String surName) {
            this.surName = surName;
            return this;
        }

        public Name build() {
            return new Name(this);
        }

    }
}
