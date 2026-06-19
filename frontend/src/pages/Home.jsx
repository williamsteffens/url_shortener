import { useState } from "react";
import api from "../api/client";

const Home = () => {
  const [url, setUrl] = useState("");
  const [shortUrl, setShortUrl] = useState("");

  async function handleSubmit(e) {
    e.preventDefault();

    const response = await api.post("/shorten", {
      originalUrl: url,
    });

    setShortUrl(response.data.shortUrl);
  }

  return (
    <div>
      <h1>URL Shortener</h1>

      <form onSubmit={handleSubmit}>
        <input
          type="url"
          placeholder="https://example.com"
          value={url}
          onChange={(e) => setUrl(e.target.value)}
        />

        <button type="submit">
          Shorten
        </button>
      </form>

      {shortUrl && (
        <div>
          <p>{shortUrl}</p>
        </div>
      )}
    </div>
  );
}

export default Home;