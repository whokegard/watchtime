import {Input, Col, Form, Row, Button} from 'antd';
import React from "react";
import "./../../css/SignIn.css";
import { useNavigate} from "react-router";
import {registerAMember} from "../../client";
import {Link} from "react-router-dom";


const Register = () => {
    const navigate = useNavigate();

        const onFinish = member => {
            registerAMember(member);
            navigate("/signin")
        };

        const onFinishFailed = errorInfo => {
            alert(JSON.stringify(errorInfo, null, 2));
        };

        return (
            <div className="signin">
                <div className="login-form">
                <div className="title">Register Account</div>
                <Form layout="vertical"
                      onFinishFailed={onFinishFailed}
                      onFinish={onFinish}
                      hideRequiredMark>
                    <Row gutter={16}>
                        <Col span={12}>
                            <Form.Item
                                name="first_name"
                                label="First name"
                                rules={[{required: true, message: 'Please enter your first name'}]}
                            >
                                <Input/>
                            </Form.Item>
                        </Col>
                        <Col span={12}>
                            <Form.Item
                                name="last_name"
                                label="Last name"
                                rules={[{required: true, message: 'Please enter your last name'}]}
                            >
                                <Input />
                            </Form.Item>
                        </Col>
                    </Row>
                    <Row gutter={16}>
                        <Col span={12}>
                            <Form.Item
                                name="email"
                                label="Email"
                                rules={[{required: true, message: 'Please enter your email'}]}
                            >
                                <Input placholder={"Please enter Username"} />
                            </Form.Item>
                        </Col>
                    </Row>
                    <Row gutter={16}>
                        <Col span={12}>
                            <Form.Item
                                name="username"
                                label="Username"
                                rules={[{required: true, message: 'Please enter your username'}]}
                            >
                                <Input />
                            </Form.Item>
                        </Col>
                    </Row>
                    <Row gutter={16}>
                        <Col span={12}>
                            <Form.Item
                                name="password"
                                label="Password"
                                rules={[{required: true, message: 'Please enter password'}]}
                            >
                                <Input placholder={"Please enter password"} />
                            </Form.Item>
                        </Col>
                    </Row>
                            <Link className="register" to="/signin">Already got an account?</Link>
                    <Row>
                        <Col span={12}>
                            <Form.Item >
                                <input type="submit" value="Register" />
                                <div className="button-container"></div>
                            </Form.Item>
                        </Col>
                    </Row>
                </Form>
            </div>
            </div>
        );
    }

export default Register;