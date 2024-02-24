import React from 'react'
import propTypes from 'prop-types';
import Sidebar from './AdminSidebar';
import Grid from '@mui/material/Grid';

const AdminLayout =({children})=> {
    return (
        <div>
            <header>

            </header>
            <main style={{position: 'absolute', paddingTop: '15px'}}>
              {children}
            </main>
            <footer>

            </footer>
        </div>
    )
}

AdminLayout.prototype = {
    children : propTypes.node.isRequired
}

export default AdminLayout
