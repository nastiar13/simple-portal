import { apiClient } from 'src/axios/apiClient';

export const getAllUsers = async () => {
  const response = await apiClient.get('/users');

  return response.data;
};
