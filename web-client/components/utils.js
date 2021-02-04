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
  INR: "fa-rupee-sign",
  CAD: "fas-dollar-sign",
  USD: "fas-dollar-sign",
  GBP: "fas-pound-sign",
  EUR: "fas-euro-sign",
  AUD: "fas-dollar-sign",
  NZD: "fas-dollar-sign",
  JPY: "fas-yen-sign",
  CNY: "fas-yen-sign",
};

export const CURRENCY_UTILS = { currencyCodeToFaClass };

export const NUMBER_UTILS = {
  convertNumToMoney,
  convertStrToNum,
};
