import api from "./client";

export const shortenUrl = async (originalUrl) => {
    const response = await api.post("/shorten", {
        originalUrl,
    });

    return response.data;
};

export const getUrl = async (shortCode) => {
    const response = await api.get(`/${shortCode}`);
    return response.data;
};