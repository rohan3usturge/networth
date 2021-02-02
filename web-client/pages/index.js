import { NETWORTH_API } from "../apis/networth_api";
import withAppLayout from "../components/layout/app-layout";
import { NetWorthContainer } from "../components/networth/container";

const Home = ({ networth }) => {
  return (
    <div>
      <NetWorthContainer defaultNetworth={networth} />
    </div>
  );
};

export default withAppLayout(Home);

export async function getServerSideProps() {
  const lineItems = await NETWORTH_API.getDefaultLineItems();
  const netWorth = {};
  return {
    props: {
      networth: content || {},
    },
  };
}
