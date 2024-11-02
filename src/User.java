public class User {
    private String name;
    private String surname;

    private User(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public static class Builder {
        private String name;
        private String surname;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public User build() {
            if (name.isEmpty() || surname.isEmpty()) {
                throw new IllegalArgumentException("Name and surname are required");
            }
            return new User(this);
        }
    }
} //Builder: in User class allows to customize the object and add only needed properties