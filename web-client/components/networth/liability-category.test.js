import { shallow } from "enzyme";
import { LiablityCategory } from "./liability-category";

describe("AssetCategory", () => {
  it("should render properly and match snapshot", () => {
    const wrapper = shallow(
      <LiablityCategory
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
