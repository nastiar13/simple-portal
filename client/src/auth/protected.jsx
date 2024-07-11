import React from 'react';
import PropTypes from 'prop-types';

export default function Protected({ children }) {
  React.useEffect(() => {
    if (sessionStorage.getItem('token') === null) {
      window.location.pathname = '/login';
    }
  }, []);

  return <>{children}</>;
}

Protected.propTypes = {
  children: PropTypes.node,
};
