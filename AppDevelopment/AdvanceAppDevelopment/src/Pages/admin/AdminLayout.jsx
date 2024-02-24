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
                
            <Grid container spacing={2} >
                <div>

                <Grid item xs={4}>  
                    <Sidebar/>
                </Grid>
                </div>
                <div>

                <Grid item xs={8} justifyContent="center"> {/* Adjust as needed */}
  {children}
</Grid>
                </div>
            </Grid>
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
