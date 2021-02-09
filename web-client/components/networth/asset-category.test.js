import { shallow } from "enzyme";
import { AssetCategory } from "./asset-category";
import { Asset } from "./asset";

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

  it("should call onChage correctly", () => {
    const category = {
      meta: {
        id: "1",
        name: "One",
      },
      items: [
        {
          lineItem: {
            id: 1,
            name: "One",
          },
        },
        {
          lineItem: {
            id: 2,
            name: "Two",
          },
        },
      ],
    };
    const onChange = jest.fn((changed) => {
      expect(changed).not.toBeNull();
      expect(changed.items).not.toBeNull();
      expect(changed.items).toHaveLength(2);
      expect(changed.items[0].lineItem.name).toBe("Three");
    });

    const wrapper = shallow(
      <AssetCategory
        category={category}
        currency="CAD"
        disabled={true}
        onChange={onChange}
        key="2323"
      />
    );

    const props = wrapper.find(Asset).first().props();
    const changeFunctionCall = props.onChange;
    changeFunctionCall({
      lineItem: {
        id: 1,
        name: "Three",
      },
    });
    expect(onChange).toHaveBeenCalledTimes(1);
  });

  it("should not call onChage if not provided", () => {
    const category = {
      meta: {
        id: "1",
        name: "One",
      },
      items: [
        {
          lineItem: {
            id: 1,
            name: "One",
          },
        },
        {
          lineItem: {
            id: 2,
            name: "Two",
          },
        },
      ],
    };

    const wrapper = shallow(
      <AssetCategory
        category={category}
        currency="CAD"
        disabled={true}
        key="2323"
      />
    );

    const props = wrapper.find(Asset).first().props();
    const changeFunctionCall = props.onChange;
    changeFunctionCall({
      lineItem: {
        id: 1,
        name: "Three",
      },
    });
  });
});
