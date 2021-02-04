const convertStrToNum = (str) => {
  return Number(String(str).replace(/[^0-9.]+/g, ""));
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

export const NUMBER_UTILS = { convertNumToMoney, convertStrToNum };
