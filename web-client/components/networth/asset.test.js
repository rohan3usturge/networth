import { shallow } from "enzyme";
import { Asset } from "./asset";

describe("Liability", () => {
  it("should render properly and match snapshot", () => {
    const wrapper = shallow(
      <Asset
        asset={{ meta: {}, lineItem: {} }}
        currency="CAD"
        disabled={true}
        onChange={() => {}}
      />
    );
    expect(wrapper).toMatchSnapshot();
  });
});
