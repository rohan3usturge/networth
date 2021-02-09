import { shallow } from "enzyme";
import { Wrapper } from "./asset-category-list";
import { AssetCategory } from "./asset-category";

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

  it("should call onChage correctly", () => {
    const translations = {
      currency: "Currency",
    };

    const categories = [
      {
        meta: {
          id: "1",
          name: "One",
        },
      },
      {
        meta: {
          id: "2",
          name: "Two",
        },
      },
    ];

    const onChange = jest.fn((changed) => {
      expect(changed).toHaveLength(2);
      expect(changed[0].meta.name).toBe("Three");
    });

    const wrapper = shallow(
      <Wrapper
        categories={categories}
        currency="CAD"
        disabled={true}
        onChange={onChange}
        total="2323.0232"
        key="2323"
        t={(key) => translations["currency"]}
      />
    );

    const props = wrapper.find(AssetCategory).first().props();
    const changeFunctionCall = props.onChange;
    changeFunctionCall({
      meta: {
        id: "1",
        name: "Three",
      },
    });
    expect(onChange).toHaveBeenCalledTimes(1);
  });

  it("should not call onChage if not pased", () => {
    const translations = {
      currency: "Currency",
    };

    const categories = [
      {
        meta: {
          id: "1",
          name: "One",
        },
      },
      {
        meta: {
          id: "2",
          name: "Two",
        },
      },
    ];

    const wrapper = shallow(
      <Wrapper
        categories={categories}
        currency="CAD"
        disabled={true}
        total="2323.0232"
        key="2323"
        t={(key) => translations["currency"]}
      />
    );

    const props = wrapper.find(AssetCategory).first().props();
    const changeFunctionCall = props.onChange;
    changeFunctionCall({
      meta: {
        id: "1",
        name: "Three",
      },
    });
  });
});
