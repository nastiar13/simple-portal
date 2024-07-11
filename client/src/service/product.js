import { apiClient } from 'src/axios/apiClient';

export const getAllProducts = async () => {
  const response = await apiClient.get('/products/');

  return response.data;
};
