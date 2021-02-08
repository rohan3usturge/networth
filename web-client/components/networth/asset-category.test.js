import { shallow } from "enzyme";
import { AssetCategory } from "./asset-category";

describe("AssetCategory", () => {
  it("should render properly and match snapshot", () => {
    const wrapper = shallow(
      <AssetCategory
        category={{ meta: {}, items: [] }}
        currency="CAD"
        disabled={true}
        onChange={() => {}}
        key="2323"
      />
    );
    expect(wrapper).toMatchSnapshot();
  });
});
