import Head from "next/head";
import Link from "next/link";

const Header = ({ locale }) => (
  <div>
    <Head>
      <title>Net Worth Calculator</title>
      <link rel="icon" href="/favicon.ico" />
    </Head>
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container-fluid">
        <a className="navbar-brand">
          <span className="h4">
            NET WORTH <em>calc</em>
          </span>
        </a>
        <div className="navbar-collapse">
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
          </ul>
        </div>
      </div>
    </nav>
  </div>
);

export { Header };
