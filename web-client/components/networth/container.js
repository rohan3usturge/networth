import { CurrencyForm } from "./../currency/currency-form";
import { AssetCategoryList } from "./asset-category-list";
import { LiabilityCategoryList } from "./liability-category-list";
import { useState } from "react";
import { NETWORTH_API } from "../../apis/networth_api";
import { NUMBER_UTILS, TIME_UTILS } from "../utils";
import { withTranslation } from "react-i18next";
import { useRouter } from "next/router";

const Wrapper = ({ defaultPortfolio, currencies, t }) => {
  const [portfolio, setPortfolio] = useState(defaultPortfolio || {});
  const [isLoading, setIsLoading] = useState(false);

  const fetchNetWorth = async (currentPortfolio, targetCurrencyCode) => {
    setIsLoading(true);
    targetCurrencyCode = targetCurrencyCode || currentPortfolio.currencyCode;
    const nwRequest = {
      portfolio: currentPortfolio,
      targetCurrencyCode,
    };
    const nw = await NETWORTH_API.getNetWorth(nwRequest);
    await TIME_UTILS.timeout(300);
    setIsLoading(false);
    setPortfolio(nw.portfolio);
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
    fetchNetWorth(portfolio, changedC);
  };

  return (
    <>
      {isLoading && (
        <div className="d-flex justify-content-center">
          <div className="spinner-grow text-primary" role="status">
            <span className="sr-only">Loading...</span>
          </div>
        </div>
      )}

      <CurrencyForm
        selectedCurrency={portfolio.currencyCode}
        currencies={currencies}
        onChange={handleCurrencyChange}
      />
      <div className="card text-white bg-primary mb-3">
        <div className="card-body">
          <h3 className="card-title">
            {portfolio.netWorth && (
              <span>
                {NUMBER_UTILS.convertNumToMoney(
                  portfolio.netWorth.totalNetWorth,
                  portfolio.currencyCode,
                  useRouter().locale
                )}
              </span>
            )}
          </h3>
          <span className="card-text">
            <i className="fas fa-balance-scale mr-2"></i>
            {t("totalNetWorth")}
          </span>
        </div>
      </div>
      <AssetCategoryList
        currency={portfolio.currencyCode}
        categories={portfolio.lineItems.assets}
        onChange={handleAssetChange}
        disabled={isLoading}
        total={portfolio.netWorth ? portfolio.netWorth.totalAssets : undefined}
      />
      <LiabilityCategoryList
        currency={portfolio.currencyCode}
        categories={portfolio.lineItems.liabilities}
        onChange={handleLiabilitiesChange}
        disabled={isLoading}
        total={
          portfolio.netWorth ? portfolio.netWorth.totalLiabilities : undefined
        }
      />
    </>
  );
};

const NetWorthContainer = withTranslation()(Wrapper);

export { NetWorthContainer, Wrapper };
