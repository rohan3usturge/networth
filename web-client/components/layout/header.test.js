import { Header } from "./header";
import { shallow } from "enzyme";
import { render, fireEvent, screen } from "@testing-library/react";

describe("Header", () => {
  it("should render properly and match snapshot", () => {
    const wrapper = shallow(<Header />);
    expect(wrapper).toMatchSnapshot();
  });
  it("should render properly and match snapshot for french", () => {
    const wrapper = shallow(<Header locale="fr-ca" />);
    expect(wrapper).toMatchSnapshot();
  });
  it("should render properly and match snapshot for english", () => {
    const wrapper = shallow(<Header locale="en-ca" />);
    expect(wrapper).toMatchSnapshot();
  });

  it("should render properly and match snapshot", () => {
    render(<Header locale="fr-ca" />);
    const menu = screen.getByTestId("navbarSupportedContent");
    const button = screen.getByTestId("menuButton");
    expect(menu.classList[1]).toBe("collapse");
    fireEvent.click(button);
    expect(menu.classList[1]).not.toBeDefined();
  });
});
