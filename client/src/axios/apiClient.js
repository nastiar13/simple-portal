import axios from 'axios';

export const apiClient = axios.create({
  baseURL: 'http://localhost:8080/api',
});

apiClient.interceptors.request.use((request) => {
  request.headers.set({
    'Content-type': 'application/json',
    'Access-Control-Allow-Origin': '*',
    Accept: '*/*',
  });

  if (sessionStorage.getItem('token') !== null) {
    request.headers.setAuthorization(`Bearer ${sessionStorage.getItem('token')}`);
  }

  console.groupCollapsed(`🚀 API REQUEST ${request.url} 🚀`);
  console.info({
    URL: request.url,
    METHOD: request.method,
    REQUEST: request.data,
  });
  console.groupEnd();

  return request;
});

apiClient.interceptors.response.use(
  (response) => {
    console.groupCollapsed(`✅ API RESPONSE ${response.config.url} ✅`);
    console.info({
      URL: response.config.url,
      RESPONSE: response.data,
    });
    console.groupEnd();

    return response;
  },
  (error) => {
    console.groupCollapsed(`🚨 API ERROR RESPONSE ${error.config.url} 🚨`);
    console.info({
      URL: error.config.url,
      RESPONSE: error.response.data,
    });
    console.groupEnd();

    if (error.response.status === 403) {
      sessionStorage.removeItem('token');
      window.location.pathname('/login');
    }
    throw error;
  }
);
