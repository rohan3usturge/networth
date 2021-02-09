import { shallow } from "enzyme";
import { Wrapper } from "./container";
import { NETWORTH_API } from "../../apis/networth_api";
import { AssetCategoryList } from "./asset-category-list";
import { LiabilityCategoryList } from "./liability-category-list";
import { CurrencyForm } from "../currency/currency-form";

jest.mock("../../apis/networth_api");
jest.mock("../utils");

jest.mock("next/router", () => {
  return {
    useRouter: () => ({ locale: "en-ca" }),
  };
});

describe("NetWorthContainer", () => {
  it("should render properly and match snapshot", () => {
    const portfolio = {
      netWorth: {
        totalAssets: 0,
        totalNetWorth: 0,
        totalLiabilities: 0,
      },
      currencyCode: "CAD",
      lineItems: { assets: [], liabilities: [] },
    };
    const wrapper = shallow(
      <Wrapper defaultPortfolio={portfolio} t={(key) => key} />
    );
    expect(wrapper).toMatchSnapshot();
  });

  it("should render properly with no networth and match snapshot", () => {
    const portfolio = {
      currencyCode: "CAD",
      lineItems: { assets: [], liabilities: [] },
    };
    const wrapper = shallow(
      <Wrapper defaultPortfolio={portfolio} t={(key) => key} />
    );
    expect(wrapper).toMatchSnapshot();
  });

  it("should call api on asset category change", () => {
    const assets = [
      {
        meta: {
          id: "1",
          name: "One",
        },
      },
    ];
    const changed = [
      {
        meta: {
          id: "2",
          name: "Two",
        },
      },
    ];
    const portfolio = {
      netWorth: {},
      currencyCode: "CAD",
      lineItems: { assets },
    };

    NETWORTH_API.getNetWorth.mockImplementation((netWorthRequest) => {
      expect(netWorthRequest).toBeDefined();
      expect(netWorthRequest.portfolio).toBeDefined();
      expect(netWorthRequest.portfolio.currencyCode).toBeDefined();
      expect(netWorthRequest.portfolio.lineItems.assets).toBeDefined();
      return netWorthRequest;
    });

    const wrapper = shallow(
      <Wrapper defaultPortfolio={portfolio} t={(key) => key} />
    );
    const props = wrapper.find(AssetCategoryList).props();
    const changeFunctionCall = props.onChange;
    changeFunctionCall(changed);
    expect(NETWORTH_API.getNetWorth).toHaveBeenCalledTimes(1);
  });

  it("should call api on liability Category change", () => {
    const liabilities = [
      {
        meta: {
          id: "1",
          name: "One",
        },
      },
    ];
    const changed = [
      {
        meta: {
          id: "2",
          name: "Two",
        },
      },
    ];
    const portfolio = {
      netWorth: {},
      currencyCode: "CAD",
      lineItems: { liabilities },
    };

    NETWORTH_API.getNetWorth.mockImplementation((netWorthRequest) => {
      expect(netWorthRequest).toBeDefined();
      expect(netWorthRequest.portfolio).toBeDefined();
      expect(netWorthRequest.portfolio.currencyCode).toBeDefined();
      expect(netWorthRequest.portfolio.lineItems.liabilities).toBeDefined();
      return netWorthRequest;
    });

    const wrapper = shallow(
      <Wrapper defaultPortfolio={portfolio} t={(key) => key} />
    );
    const props = wrapper.find(LiabilityCategoryList).props();
    const changeFunctionCall = props.onChange;
    changeFunctionCall(changed);
    expect(NETWORTH_API.getNetWorth).toHaveBeenCalledTimes(1);
  });

  it("should call api on currency change", () => {
    const portfolio = {
      netWorth: {},
      currencyCode: "CAD",
      lineItems: {},
    };

    NETWORTH_API.getNetWorth.mockImplementation((netWorthRequest) => {
      expect(netWorthRequest).toBeDefined();
      expect(netWorthRequest.portfolio).toBeDefined();
      expect(netWorthRequest.targetCurrencyCode).toBe("USD");
      expect(netWorthRequest.portfolio.currencyCode).toBeDefined();
      expect(netWorthRequest.portfolio.currencyCode).toBe("CAD");
      return netWorthRequest;
    });

    const wrapper = shallow(
      <Wrapper defaultPortfolio={portfolio} t={(key) => key} />
    );
    const props = wrapper.find(CurrencyForm).props();
    const changeFunctionCall = props.onChange;
    changeFunctionCall("USD");
    expect(NETWORTH_API.getNetWorth).toHaveBeenCalledTimes(1);
  });

  afterEach(() => {
    NETWORTH_API.getNetWorth.mockClear();
  });
});
