import i18n from "i18next";
import { initReactI18next } from "react-i18next";
import enTranslation from "./translations/en.json";
import frTranslation from "./translations/fr.json";

const resources = {
  en: {
    translation: enTranslation,
  },
  fr: {
    translation: frTranslation,
  },
};

const init = (locale) => {
  let lang = "en";
  if (locale) {
    lang = locale.split("-")[0];
  }
  i18n
    .use(initReactI18next) // passes i18n down to react-i18next
    .init({
      resources,
      lng: lang,
      keySeparator: false, // we do not use keys in form messages.welcome
      interpolation: {
        escapeValue: false, // react already safes from xss
      },
    });
};

export default init;
