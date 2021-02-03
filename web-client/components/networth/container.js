import { CurrencyForm } from "./../currency/currency-form";
import { AssetCategoryList } from "./asset-category-list";
import { LiabilityCategoryList } from "./liability-category-list";
import { useState } from "react";
import { NETWORTH_API } from "../../apis/networth_api";

const NetWorthContainer = ({ defaultPortfolio }) => {
  const [portfolio, setPortfolio] = useState(defaultPortfolio || {});

  const fetchNetWorth = async (portfolioRequest) => {
    const nw = await NETWORTH_API.getNetWorth(portfolioRequest);
    console.log({ nw });
  };

  const handleLiabilitiesChange = (changedL) => {
    const changed = { ...portfolio };
    changed.lineItems.liabilities = changedL;
    setPortfolio(changed);
    fetchNetWorth(changed);
  };

  const handleAssetChange = (changedA) => {
    const changed = { ...portfolio };
    changed.lineItems.assets = changedA;
    setPortfolio(changed);
    fetchNetWorth(changed);
  };

  const handleCurrencyChange = (changedC) => {
    const changed = { ...portfolio };
    changed.targetCurrencyCode = changedC;
    setPortfolio(changed);
    fetchNetWorth(changed);
  };

  return (
    <>
      <div>TARGET - {portfolio.targetCurrencyCode}</div>
      <div>CURRENT - {portfolio.currencyCode}</div>
      <CurrencyForm
        selectedCurrency={portfolio.currencyCode}
        currencies={[
          { currencyCode: "CAD" },
          { currencyCode: "USD" },
          { currencyCode: "INR" },
        ]}
        onChange={handleCurrencyChange}
      />
      <AssetCategoryList
        categories={portfolio.lineItems.assets}
        onChange={handleAssetChange}
      />
      <LiabilityCategoryList
        categories={portfolio.lineItems.liabilities}
        onChange={handleLiabilitiesChange}
      />
    </>
  );
};

export { NetWorthContainer };
