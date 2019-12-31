import React, { Component } from 'react';
import axios from 'axios';

import classes from './DockerStatus.module.css';

import Container from './Container/Container';

class DockerStatus extends Component {
    constructor(props) {
        super(props);
    
        this.state= {
            status: {
                id: 0,
                statusGood: false,
                containersList: []
            }
        };
    
        this.checkStatus = this.checkStatus.bind(this);
    }

    state= {
        status: {
            id: 0,
            statusGood: false,
            containersList: []
        }
    }
    /** 
     * Example of good state:
        {
            "id":2,
            "statusGood":true,
            "containersList":[
                {
                    "id":3,
                    "statusGood":false,
                    "containerName":"apache-wls"
                },{
                    "id":4,
                    "statusGood":false,
                    "containerName":"oracle11g"
                },{
                    "id":5,
                    "statusGood":false,
                    "containerName":"bgs_mock"
                }
            ]
        }
    */

    checkStatus() {
        axios.get('http://localhost:8080/docker/status')
        .then(response => {
            const updatedStatus = response.data;
            
            this.setState({status: updatedStatus});
        });
    }

    componentDidMount() {
        this.checkStatus()
    }

    render() {
        const containers = this.state.status.containersList.map(container => {
            return <Container key={container.id} name={container.containerName} status={container.statusGood} />
        })

        let statusText = "Docker is not running!";

        if (this.state.status.statusGood) {
            statusText = "Docker is running!!! Yay!"
        }

        return (
            <div className={classes.DockerStatus}>
                {statusText}

                <svg onClick={this.checkStatus} className={classes.spin} xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M9 12l-4.463 4.969-4.537-4.969h3c0-4.97 4.03-9 9-9 2.395 0 4.565.942 6.179 2.468l-2.004 2.231c-1.081-1.05-2.553-1.699-4.175-1.699-3.309 0-6 2.691-6 6h3zm10.463-4.969l-4.463 4.969h3c0 3.309-2.691 6-6 6-1.623 0-3.094-.65-4.175-1.699l-2.004 2.231c1.613 1.526 3.784 2.468 6.179 2.468 4.97 0 9-4.03 9-9h3l-4.537-4.969z"/></svg>
                
                {containers}
            </div>
        )
    }
}

export default DockerStatus;