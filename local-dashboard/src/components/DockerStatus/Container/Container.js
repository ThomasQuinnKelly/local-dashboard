import React from 'react';

const container = (props) => {
 
    let status = props.status ? "is running" : "is not running :(";

    let style = {display: 'inline-block', height: '25px', width: '25px', backgroundColor: '#cc0000', color: '#ffffff'};
    
    if (props.status) {
        style = {display: 'inline-block', height: '25px', width: '25px', backgroundColor: '#00cc00', color: '#ffffff'};
    } 
   
    return ( 
        <div> 
            <div style={style}></div> {props.name} {status}
        </div>
    );

};
export default container;