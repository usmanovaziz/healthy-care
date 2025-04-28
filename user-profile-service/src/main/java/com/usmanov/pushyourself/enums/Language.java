package com.usmanov.pushyourself.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Language {

    ARABIC("العربية", "ar"),
    CHINESE("中文 ", "zh"),
    ENGLISH("English", "en"),
    FRENCH("Français", "fr"),
    GERMAN("Deutsch", "de"),
    ITALIAN("Italiano", "it"),
    KAZAKH("Қазақ тілі", "kk"),
    KIRGHIZ("Кыргызча", "ky"),
    RUSSIAN("Русский", "ru"),
    SPANISH("Español", "es"),
    TAJIK("Toҷикй", "tj"),
    UZBEK("Oʻzbek", "uz");

    @Getter
    private String nativeName;

    @Getter
    private String isoName;

    Language(String nativeName, String isoName) {
        this.nativeName = nativeName;
        this.isoName = isoName;
    }

    @JsonCreator
    public static Language getByIsoName(String lang) {
        for (Language l : Language.values()) {
            if (l.isoName.equals(lang))
                return l;
        }
        throw new IllegalArgumentException("Wrong ISO Locale");
    }

    @JsonValue
    public String toValue() {
        return isoName;
    }
}
