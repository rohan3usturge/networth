import { shallow } from "enzyme";
import { Liability } from "./liability";

jest.mock("next/router", () => {
  return {
    useRouter: () => ({ locale: "en-ca" }),
  };
});

describe("Liability", () => {
  it("should render properly and match snapshot", () => {
    const wrapper = shallow(
      <Liability
        liability={{ meta: {}, lineItem: {} }}
        currency="CAD"
        disabled={true}
        onChange={() => {}}
      />
    );
    expect(wrapper).toMatchSnapshot();
  });
});
