import { shallow } from "enzyme";
import { Amount } from "./amount";

jest.mock("next/router", () => {
  return {
    useRouter: () => ({ locale: "en-ca" }),
  };
});

describe("Amount", () => {
  it("should render properly and match snapshot", () => {
    const wrapper = shallow(
      <Amount
        defaultValue="3.00"
        currency="CAD"
        disabled={true}
        onChange={() => {}}
        key="1212"
      />
    );
    expect(wrapper).toMatchSnapshot();
  });
});
