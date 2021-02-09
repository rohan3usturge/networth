import { NETWORTH_API } from "./networth_api";
import axios from "axios";

jest.mock("axios");

jest.mock(
  "../data/data.json",
  () => ({
    test: "english",
  }),
  { virtual: true }
);

jest.mock(
  "../data/data_fr.json",
  () => ({
    test: "french",
  }),
  { virtual: true }
);

describe("NetWorthApi.getDefaultLineItems", () => {
  it("should return english for undefine locale", async () => {
    const lineItems = await NETWORTH_API.getDefaultLineItems();
    expect(lineItems.test).toBe("english");
  });
  it("should return english for en-Ca locale", async () => {
    const lineItems = await NETWORTH_API.getDefaultLineItems("en-ca");
    expect(lineItems.test).toBe("english");
  });
  it("should return english for en locale", async () => {
    const lineItems = await NETWORTH_API.getDefaultLineItems("en");
    expect(lineItems.test).toBe("english");
  });
  it("should return french for fr locale", async () => {
    const lineItems = await NETWORTH_API.getDefaultLineItems("fr");
    expect(lineItems.test).toBe("french");
  });
  it("should return french for fr-ca locale", async () => {
    const lineItems = await NETWORTH_API.getDefaultLineItems("fr-ca");
    expect(lineItems.test).toBe("french");
  });
});

describe("NetWorthApi", () => {
  it("should getNetWorth call axios post with correct headers and body", async () => {
    const request = { someData: "data" };
    const response = { someData: "data" };
    axios.post.mockImplementation((baseUrl, body, options) => {
      expect(baseUrl).toBe(`undefined/networth`);
      expect(options.headers.Accept).toBe("application/json");
      expect(options.headers["Content-Type"]).toBe("application/json");
      expect(body).toBe(request);
      return {
        data: response,
      };
    });
    const lineItems = await NETWORTH_API.getNetWorth(request);
    expect(lineItems).toBe(response);
  });

  it("should getCurrencies call axios get with correct headers", async () => {
    const request = { someData: "data" };
    const response = { someData: "data" };
    axios.get.mockImplementation((baseUrl, options) => {
      expect(baseUrl).toBe(`undefined/networth/currencies`);
      expect(options.headers.Accept).toBe("application/json");
      expect(options.headers["Content-Type"]).toBe("application/json");
      return {
        data: response,
      };
    });
    const lineItems = await NETWORTH_API.getCurrencies(request);
    expect(lineItems).toBe(response);
  });
});
