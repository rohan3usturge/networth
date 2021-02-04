import Head from "next/head";

const Header = () => (
  <div>
    <Head>
      <title>Net Worth Calculator</title>
      <link rel="icon" href="/favicon.ico" />
    </Head>
    <nav className="navbar navbar-dark bg-dark">
      <a className="navbar-brand" href="#">
        <span className="h4">
          NET WORTH <em>calc</em>
        </span>
      </a>
    </nav>
  </div>
);

export { Header };
