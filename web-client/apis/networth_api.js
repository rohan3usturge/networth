import axios from "axios";

const baseUrl = process.env.NEXT_PUBLIC_API_BASE_URL;

const getDefaultLineItems = async () => {
  const response = await axios.get(`${baseUrl}/networth`, {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });
  return response.data;
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
