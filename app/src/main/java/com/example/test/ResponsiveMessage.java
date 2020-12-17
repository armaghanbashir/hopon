package com.example.test;

public class ResponsiveMessage  {

        String text;
        boolean isMe;

        public ResponsiveMessage(String text, boolean isMe) {
            this.text = text;
            this.isMe = isMe;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public boolean isMe() {
            return isMe;
        }

        public void setMe(boolean me) {
            isMe = me;
        }
    }

