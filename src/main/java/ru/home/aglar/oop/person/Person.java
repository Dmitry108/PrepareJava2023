package ru.home.aglar.oop.person;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public class Builder {
        public Builder() {
        }

        public Builder firstName(String firstName) {
            Person.this.setFirstName(firstName);
            return this;
        }

        public Builder lastName(String lastName) {
            Person.this.setLastName(lastName);
            return this;
        }

        public Builder middleName(String middleName) {
            Person.this.setMiddleName(middleName);
            return this;
        }

        public Builder country(String country) {
            Person.this.setCountry(country);
            return this;
        }

        public Builder address(String address) {
            Person.this.setAddress(address);
            return this;
        }

        public Builder phone(String phone) {
            Person.this.setPhone(phone);
            return this;
        }

        public Builder age(int age) {
            if (age > 0) Person.this.setAge(age);
            return this;
        }

        public Builder gender(String gender) {
            Person.this.setGender(gender);
            return this;
        }

        public Person build() {
            if (validatePerson()) {
                return Person.this;
            } else {
                System.out.println("Sorry! Person objects can't be build without required details");
            }
            return null;
        }

        private boolean validatePerson() {
            int age = Person.this.getAge();
            String firstName = Person.this.getFirstName();
            String lastName = Person.this.getLastName();
            return (age > 0 && firstName != null && !firstName.trim().isEmpty()
                    && lastName != null && !lastName.trim().isEmpty());
        }

        public static Builder builder() {
            return new Person().new Builder();
        }
    }
}