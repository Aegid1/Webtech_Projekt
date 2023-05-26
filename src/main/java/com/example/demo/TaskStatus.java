package com.example.demo;

public enum TaskStatus {

        ERLEDIGT("grün"),
        BALD_ZU_ERLEDIGEN("gelb"),
        ÜBERFÄLLIG("rot");

        private final String farbe;

        private TaskStatus(String farbe) {
            this.farbe = farbe;
        }

        public String getFarbe() {
            return farbe;
        }
}

