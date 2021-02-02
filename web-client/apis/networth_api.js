import axios from "axios";

const baseUrl = `http://localhost:8080/api`;

const getDefaultNetWorth = async () => {
  const response = await axios.get(`${baseUrl}/networth`, {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });
  return response.data;
};

export const NETWORTH_API = {
  getDefaultNetWorth,
};
