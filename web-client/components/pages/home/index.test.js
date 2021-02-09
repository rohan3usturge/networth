import Home, { getStaticProps } from "./index";
import { shallow } from "enzyme";
import { NETWORTH_API } from "../../../apis/networth_api";

jest.mock("../../../apis/networth_api");

describe("HomePage", () => {
  it("should render properly and match snapshot", () => {
    const wrapper = shallow(<Home portfolio={{}} currencies={[]} />);
    expect(wrapper).toMatchSnapshot();
  });

  it("should getStaticProps call correct apis", async () => {
    const currencies = ["CAD"];
    const lineItems = { assets: [], liabilities: [] };
    const networthResponse = {
      netWorth: {},
      lineItems,
      currencyCode: "CAD",
    };

    NETWORTH_API.getCurrencies.mockImplementation(() => currencies);
    NETWORTH_API.getDefaultLineItems.mockImplementation(() => lineItems);
    NETWORTH_API.getNetWorth.mockImplementation(() => networthResponse);

    await getStaticProps({ locale: "en-ca" });

    expect(NETWORTH_API.getCurrencies).toHaveBeenCalledTimes(1);
    expect(NETWORTH_API.getDefaultLineItems).toHaveBeenCalledTimes(1);
    expect(NETWORTH_API.getNetWorth).toHaveBeenCalledTimes(1);
  });
});
