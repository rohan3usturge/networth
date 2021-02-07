import axios from "axios";
import en from "../data/data.json";
import fr from "../data/data_fr.json";

const baseUrl = process.env.NEXT_PUBLIC_API_BASE_URL;

const getDefaultLineItems = async (locale) => {
  if (locale && locale.indexOf("fr") > -1) {
    return fr;
  }

  return en;

  // const response = await axios.get(`${baseUrl}/networth`, {
  //   headers: {
  //     Accept: "application/json",
  //     "Content-Type": "application/json",
  //   },
  // });
  // return response.data;
};

const getNetWorth = async (netWorthCalculateRequest) => {
  const response = await axios.post(
    `${baseUrl}/networth`,
    netWorthCalculateRequest,
    {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }
  );
  return response.data;
};

const getCurrencies = async () => {
  const response = await axios.get(`${baseUrl}/networth/currencies`, {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });
  return response.data;
};

export const NETWORTH_API = {
  getDefaultLineItems,
  getNetWorth,
  getCurrencies,
};
