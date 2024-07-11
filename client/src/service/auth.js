import { apiClient } from 'src/axios/apiClient';

export const loginService = async (payload) => {
  const response = await apiClient.post('/auth/login', payload);

  return response.data;
};
