import App from "./_app";
import { shallow } from "enzyme";
import init from "../i18n";

jest.mock("../i18n");

describe("Footer", () => {
  it("should render properly and match snapshot", () => {
    const props = {
      Component: () => <span>Test</span>,
      pageProps: { locale: "en-ca" },
    };
    const wrapper = shallow(<App {...props} />);
    expect(wrapper).toMatchSnapshot();
    expect(init).toHaveBeenCalledWith("en-ca");
  });
});
