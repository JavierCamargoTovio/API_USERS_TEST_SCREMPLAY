package co.com.test.users.model.dto;


public final class UserModel {

    private String name;
    private String job;

    public UserModel(UserBuilder builder) {
        this.name = builder.name;
        this.job = builder.job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public static class UserBuilder {
        private String name;
        private String job;


        public UserBuilder isWithName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder isWithJob(String job) {
            this.job = job;
            return this;
        }

        public UserModel build() {
            return new UserModel(this);
        }
    }
}
