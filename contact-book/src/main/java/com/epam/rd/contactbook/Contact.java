package com.epam.rd.contactbook;

public class Contact {
    private String contactName;
    private final String Title = "Name";

    private final Email[] emails = new Email[3];
    private int countOfEmails = 0;
    private final Social[] socials = new Social[5];
    private int countOfSocials = 0;
    private boolean isTelephoneNumber = false;
    ContactInfo number1;


    public Contact(String contactName) {
        if(contactName == null || contactName.length() == 0){
            throw new IllegalArgumentException();
        }
        this.contactName = contactName;
    }

    private class NameContactInfo implements ContactInfo{
        public NameContactInfo(String name){
            contactName = name;
        }
        @Override
        public String getTitle(){
            return Title;
        }
        @Override
        public String getValue(){
            return contactName;
        }

        @Override
        public String toString() {
            return Title + ": " + contactName;
        }
    }

    public static class Email implements ContactInfo{
        private String Title = "Email";
        private final String localPart;
        private final String domain;
        public Email(String localPart, String domain){
            this.localPart = localPart;
            this.domain = domain;
        }
        protected Email(String localPart, String domain, String Title){
            this.localPart = localPart;
            this.domain = domain;
            this.Title = Title;
        }
        @Override
        public String getTitle(){
            return Title;
        }
        @Override
        public String getValue(){
            return localPart + "@" + domain;
        }

        @Override
        public String toString() {
            return Title + ": " + getValue();
        }
    }

    public static class Social implements ContactInfo{
        private final String Title;
        private final String mediaLink;

        public Social(String Title, String mediaLink){
            this.Title = Title;
            this.mediaLink = mediaLink;
        }
        @Override
        public String getTitle(){
            return Title;
        }
        @Override
        public String getValue(){
            return mediaLink;
        }

        @Override
        public String toString() {
            return Title + ": " + mediaLink;
        }
    }

    public void rename(String newName) {
        if(newName == null || newName.length() == 0){

        }else{
            contactName = newName;
        }

    }

    public Email addEmail(String localPart, String domain) {
        if(localPart == null || localPart.length() == 0 || domain == null || domain.length() == 0){
            return  null;
        }
        if(countOfEmails == emails.length){
            return null;
        }
        emails[countOfEmails] = new Email(localPart, domain);
        return emails[countOfEmails++];
    }


    public Email addEpamEmail(String firstname, String lastname) {
        if(firstname == null || firstname.length() == 0 || lastname == null || lastname.length() == 0){
            return null;
        }
        if(countOfEmails == emails.length){
            return null;
        }
        Email em = new Email(firstname + "_" + lastname, "epam.com", "Epam Email"){
        };
        emails[countOfEmails++] = em;
        return em;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if(code <= 0 || number == null || number.length() == 0){
            return null;
        }
        if(isTelephoneNumber){
            return null;
        }
        isTelephoneNumber = true;
        number1 = new ContactInfo() {
            @Override
            public String getTitle() {
                return "Tel";
            }
            @Override
            public String getValue() {
                return "+" + code + " " + number;
            }
        };
        return number1;
    }

    public Social addTwitter(String twitterId) {
        if(twitterId == null || twitterId.length() == 0){
            return null;
        }
        if(countOfSocials == socials.length){
            return null;
        }
        socials[countOfSocials] = new Social("Twitter", twitterId);
        return socials[countOfSocials++];
    }

    public Social addInstagram(String instagramId) {
        if(instagramId == null || instagramId.length() == 0){
            return null;
        }
        if(countOfSocials == socials.length){
            return null;
        }
        socials[countOfSocials] = new Social("Instagram", instagramId);
        return socials[countOfSocials++];
    }

    public Social addSocialMedia(String title, String id) {
        if(id == null || id.length() == 0){
            return null;
        }
        if(countOfSocials == socials.length){
            return null;
        }
        socials[countOfSocials] = new Social(title, id);
        return socials[countOfSocials++];
    }

    public ContactInfo[] getInfo() {
        ContactInfo[] information = new ContactInfo[10];
        int filledInformation = 0;
        information[filledInformation++] = new NameContactInfo(contactName);
        if(isTelephoneNumber){
            information[filledInformation++] = number1;
        }
        for(Email i : emails){
            if(i != null){
                information[filledInformation++] = i;
            }
        }
        for(Social i : socials){
            if(i != null){
                information[filledInformation++] = i;
            }
        }

        ContactInfo[] info = new ContactInfo[filledInformation];
        for(int i = 0; i < filledInformation; i++){
            info[i] = information[i];
        }
        return info;
    }

}
