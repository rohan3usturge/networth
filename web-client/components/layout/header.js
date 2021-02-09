import Head from "next/head";
import Link from "next/link";
import { useState } from "react";

const DocsLink = process.env.NEXT_PUBLIC_DOCS_URL;

const Header = ({ locale }) => {
  const [isMenuVisible, setIsMenuVisible] = useState(false);
  return (
    <div>
      <Head>
        <title>Net Worth Calculator</title>
        <link rel="icon" href="/favicon.ico" />
        <meta
          name="keywords"
          content="networth, assets, liabilities, calculator"
        />
        <meta
          name="description"
          content="Calculates Networth based on assets, liabilities"
        />
        <meta name="subject" content="NetWorth Calculator" />
        <meta name="copyright" content="Intuit" />
        <meta name="language" content="en ,fr" />
        <meta name="robots" content="index,follow" />
        <meta name="abstract" content="" />
        <meta name="topic" content="" />
        <meta name="summary" content="" />
        <meta name="Classification" content="Business" />
        <meta name="coverage" content="Worldwide" />
        <meta name="distribution" content="Global" />
        <meta name="rating" content="General" />
        <meta name="revisit-after" content="1 days" />
      </Head>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <a className="navbar-brand" href="#">
          <span className="h4">
            NET WORTH <em>calc</em>
          </span>
        </a>
        <button
          className="navbar-toggler"
          type="button"
          data-testid="menuButton"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
          onClick={() => setIsMenuVisible(!isMenuVisible)}
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div
          className={`navbar-collapse ${!isMenuVisible ? "collapse" : ""}`}
          data-testid="navbarSupportedContent"
          id="navbarSupportedContent"
        >
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            <li
              className={`nav-item ${
                locale && locale.toLowerCase() == "en-ca" ? "active" : ""
              }`}
            >
              <Link href="/" locale="en-ca">
                <a className="nav-link">English</a>
              </Link>
            </li>
            <li
              className={`nav-item ${
                locale && locale.toLowerCase() == "fr-ca" ? "active" : ""
              }`}
            >
              <Link href="/" locale="fr-ca">
                <a className="nav-link">français</a>
              </Link>
            </li>
            <li className="nav-item">
              <a className="nav-link" target="_blank" href={DocsLink}>
                Docs
              </a>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  );
};

export { Header };
