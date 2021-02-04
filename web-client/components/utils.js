const convertStrToNum = (str) => {
  return Number(String(str).replace(/[^0-9.-]+/g, ""));
};

const convertNumToMoney = (currVal, currency) => {
  const options = {
    //maximumFractionDigits: 2,
    currency: currency,
    style: "currency",
    currencyDisplay: "symbol",
  };
  return currVal || currVal === 0
    ? convertStrToNum(currVal).toLocaleString(undefined, options)
    : "";
};

const currencyCodeToFaClass = {
  INR: { class: "fa-rupee-sign", label: "Indian Rupee" },
  CAD: { class: "fa-dollar-sign", label: "Canadian Dollar" },
  USD: { class: "fa-dollar-sign", label: "US Dollar" },
  GBP: { class: "fa-pound-sign", label: "British Pound" },
  EUR: { class: "fa-euro-sign", label: "Euro" },
  AUD: { class: "fa-dollar-sign", label: "Australian Dollar" },
  NZD: { class: "fa-dollar-sign", label: "New Zealand Dollar" },
  JPY: { class: "fa-yen-sign", label: "Japanese Yen" },
  CNY: { class: "fa-yen-sign", label: "Chinese Yen" },
  CHF: { class: "", label: "Swiss Franc" },
};

export const CURRENCY_UTILS = { currencyCodeToFaClass };

export const NUMBER_UTILS = {
  convertNumToMoney,
  convertStrToNum,
};
