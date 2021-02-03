import { NETWORTH_API } from "../apis/networth_api";
import withAppLayout from "../components/layout/app-layout";
import { NetWorthContainer } from "../components/networth/container";

const Home = ({ portfolio }) => {
  return (
    <div>
      <NetWorthContainer defaultPortfolio={portfolio} />
    </div>
  );
};

export default withAppLayout(Home);

export async function getServerSideProps() {
  const lineItems = await NETWORTH_API.getDefaultLineItems();
  const currencyCode = "CAD";
  const targetCurrencyCode = "CAD";

  const portfolio = {
    currencyCode,
    targetCurrencyCode,
    lineItems,
  };

  return {
    props: {
      portfolio: portfolio || {},
    },
  };
}
