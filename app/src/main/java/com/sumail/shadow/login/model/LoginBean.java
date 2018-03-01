package com.sumail.shadow.login.model;



/**
 * Created by shadow on 2017/12/6.
 *
 */

public class LoginBean {

    private int Code;
    private String Description;
    private java.lang.Object TrainNumber;
    private ObjectBean Object;
    private java.lang.Object Objects;

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public java.lang.Object getTrainNumber() {
        return TrainNumber;
    }

    public void setTrainNumber(java.lang.Object TrainNumber) {
        this.TrainNumber = TrainNumber;
    }

    public ObjectBean getObject() {
        return Object;
    }

    public void setObject(ObjectBean Object) {
        this.Object = Object;
    }

    public java.lang.Object getObjects() {
        return Objects;
    }

    public void setObjects(java.lang.Object Objects) {
        this.Objects = Objects;
    }

    public static class ObjectBean {
        private String GUID;
        private String DefaultLanguage;
        private String LastLoginTime;
        private String Name;
        private String FirstName;
        private java.lang.Object LastName;
        private String RoleName;
        private String Department;
        private String Thumb;
        private String WorkNumber;

        public String getGUID() {
            return GUID;
        }

        public void setGUID(String GUID) {
            this.GUID = GUID;
        }

        public String getDefaultLanguage() {
            return DefaultLanguage;
        }

        public void setDefaultLanguage(String DefaultLanguage) {
            this.DefaultLanguage = DefaultLanguage;
        }

        public String getLastLoginTime() {
            return LastLoginTime;
        }

        public void setLastLoginTime(String LastLoginTime) {
            this.LastLoginTime = LastLoginTime;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String FirstName) {
            this.FirstName = FirstName;
        }

        public java.lang.Object getLastName() {
            return LastName;
        }

        public void setLastName(java.lang.Object LastName) {
            this.LastName = LastName;
        }

        public String getRoleName() {
            return RoleName;
        }

        public void setRoleName(String RoleName) {
            this.RoleName = RoleName;
        }

        public String getDepartment() {
            return Department;
        }

        public void setDepartment(String Department) {
            this.Department = Department;
        }

        public String getThumb() {
            return Thumb;
        }

        public void setThumb(String Thumb) {
            this.Thumb = Thumb;
        }

        public String getWorkNumber() {
            return WorkNumber;
        }

        public void setWorkNumber(String WorkNumber) {
            this.WorkNumber = WorkNumber;
        }
    }
}
