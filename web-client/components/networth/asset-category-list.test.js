import { shallow } from "enzyme";
import { Wrapper } from "./asset-category-list";

jest.mock("next/router", () => {
  return {
    useRouter: () => ({ locale: "en-ca" }),
  };
});

describe("AssetCategoryList", () => {
  it("should render properly and match snapshot", () => {
    const translations = {
      currency: "Currency",
    };

    const wrapper = shallow(
      <Wrapper
        categories={[]}
        currency="CAD"
        disabled={true}
        onChange={() => {}}
        total="2323.0232"
        key="2323"
        t={(key) => translations["currency"]}
      />
    );
    expect(wrapper).toMatchSnapshot();
  });
});
