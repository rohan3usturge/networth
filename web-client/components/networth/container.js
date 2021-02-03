import { CurrencyForm } from "./../currency/currency-form";
import { AssetCategoryList } from "./asset-category-list";
import { LiabilityCategoryList } from "./liability-category-list";
import { useState } from "react";

const NetWorthContainer = ({ defaultPortfolio }) => {
  const [portfolio, setPortfolio] = useState(defaultPortfolio || {});

  const handleLiabilitiesChange = (changedL) => {
    const changed = { ...portfolio };
    changed.liabilities = changedL;
    setPortfolio(changed);
  };

  const handleAssetChange = (changedA) => {
    const changed = { ...portfolio };
    changed.assets = changedA;
    setPortfolio(changed);
  };

  const handleCurrencyChange = (changedC) => {
    const changed = { ...portfolio };
    changed.targetCurrencyCode = changedC;
    setPortfolio(changed);
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
        categories={portfolio.assets}
        onChange={handleAssetChange}
      />
      <LiabilityCategoryList
        categories={portfolio.liabilities}
        onChange={handleLiabilitiesChange}
      />
    </>
  );
};

export { NetWorthContainer };
