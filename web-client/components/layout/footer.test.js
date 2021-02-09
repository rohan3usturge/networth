import { Footer } from "./footer";
import { shallow } from "enzyme";

describe("Footer", () => {
  it("should render properly and match snapshot", () => {
    const wrapper = shallow(<Footer />);
    expect(wrapper).toMatchSnapshot();
  });
});
