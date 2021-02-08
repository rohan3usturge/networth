import { shallow } from "enzyme";
import { Wrapper } from "./container";

jest.mock("next/router", () => {
  return {
    useRouter: () => ({ locale: "en-ca" }),
  };
});

describe("NetWorthContainer", () => {
  const portfolio = {
    netWorth: {},
    currencyCode: "CAD",
    lineItems: { assets: [], liabilities: [] },
  };
  it("should render properly and match snapshot", () => {
    const wrapper = shallow(
      <Wrapper defaultPortfolio={portfolio} t={(key) => key} />
    );
    expect(wrapper).toMatchSnapshot();
  });
});
